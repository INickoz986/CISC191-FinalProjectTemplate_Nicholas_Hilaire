public class BrokenArrowUnitComparisonTool extends Application
{
    //TODO: used for selecting units, could consider naming or commenting for clarity
    private ComboBox<Unit> leftComboBox;
    private ComboBox<Unit> rightComboBox;

    //TODO: shows details for the selected units
    private VBox leftPanel;
    private VBox rightPanel;

    //TODO: stores loaded units and their images
    private List<Unit> unitList;
    private Map<String, Image> unitImageMap;

    @Override
    public void start(Stage primaryStage)
    {
        //TODO: path is absolute — might not work everywhere
        List<Unit> unitList = UnitStatsLoader.loadUnits("C:\\Users\\Nicko\\IdeaProjects\\CISC191-FinalProjectTemplate\\Server\\src\\main\\resources\\Broken Arrow Unit Stats.csv");

        //TODO: shows how many were loaded, mostly for debugging
        System.out.println("Units loaded: " + unitList.size());

        //TODO: groups units by type
        Map<String, List<Unit>> unitsByType = unitList.stream()
                .collect(Collectors.groupingBy(Unit::getUnitType));

        //TODO: sets up dropdown to filter units by type
        ChoiceBox<String> typeSearch = new ChoiceBox<>(
                FXCollections.observableArrayList(unitsByType.keySet()));

        //TODO: updates both unit lists when type changes
        typeSearch.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> {
            List<Unit> filtered = unitsByType.getOrDefault(newValue, unitList);
            leftComboBox.getItems().setAll(filtered);
            rightComboBox.getItems().setAll(filtered);
        });

        //TODO: image file names matched to unit names
        Map<String, String> imageFileName = Map.of(
                "Marine Raiders CQC",    "marine_raiders_cqc.png",
                "Chernye Berety",        "chernye_berety.png",
                "M1A2 SEP v2 Abrams",    "m1a2_sep_v2_abrams.png",
                "T-14 Armata",           "t14_armata.png",
                "F-35B",                 "f35b.png",
                "Su-57",                 "su57.png"
        );

        //TODO: loads all the images into memory
        unitImageMap = new HashMap<>();
        for (Map.Entry<String, String> entry : imageFileName.entrySet()) {
            InputStream is = getClass().getResourceAsStream("/images/" + entry.getValue());
            if (is == null) {
                System.err.println("Missing image resource: " + entry.getValue());
                continue;
            }
            Image img = new Image(is);
            unitImageMap.put(entry.getKey(), img);
        }

        //TODO: fills combo boxes with units
        leftComboBox = new ComboBox<>();
        rightComboBox = new ComboBox<>();
        leftComboBox.getItems().addAll(unitList);
        rightComboBox.getItems().addAll(unitList);

        //TODO: makes the dropdown only show unit name
        StringConverter<Unit> converter = new StringConverter<>() {
            @Override
            public String toString(Unit unit) {
                return unit == null ? "" : unit.getUnitName();
            }

            @Override
            public Unit fromString(String string) {
                //TODO: not used in this context
                return null;
            }
        };

        leftComboBox.setConverter(converter);
        rightComboBox.setConverter(converter);

        //TODO: sets up the two detail views
        leftPanel = createUnitDetailPanel();
        rightPanel = createUnitDetailPanel();

        //TODO: updates panel when a unit is picked
        leftComboBox.setOnAction(e -> showUnit(leftComboBox.getValue(), leftPanel));
        rightComboBox.setOnAction(e -> showUnit(rightComboBox.getValue(), rightPanel));

        //TODO: holds the search box and both selectors
        HBox topControls = new HBox(10,
                new Label("Type:"), typeSearch,
                new Label("Left Unit:"), leftComboBox,
                new Label("Right Unit:"), rightComboBox);
        topControls.setPadding(new Insets(10));

        //TODO: holds the left and right detail panels
        HBox panelsContainer = new HBox(20, leftPanel, rightPanel);
        panelsContainer.setPadding(new Insets(10));

        //TODO: main layout pane
        BorderPane root = new BorderPane();
        root.setTop(topControls);
        root.setCenter(panelsContainer);

        //TODO: sets the main window and shows it
        primaryStage.setTitle("Unit Comparison");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void showUnit(Unit unit, VBox panel)
    {
        if (unit == null) return;

        //TODO: finds the image view and sets its image
        ImageView iv = (ImageView) panel.lookup("#unitImageView");
        iv.setImage(unitImageMap.get(unit.getUnitName()));

        //TODO: updates all the unit stats on the panel
        updatePanel(panel, unit);
    }

    private VBox createUnitDetailPanel()
    {
        //TODO: makes a panel with padding and border
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: gray; -fx-border-width: 2; -fx-background-color: #f9f9f9;");

        //TODO: sets up the image
        ImageView iv = new ImageView();
        iv.setId("unitImageView");
        iv.setFitWidth(300);
        iv.setFitHeight(260);
        iv.setPreserveRatio(true);

        //TODO: creates labels for the stats
        Label nameLabel = new Label("Name: ");
        Label typeLabel = new Label("Type: ");
        Label specializationLabel = new Label("Specialization: ");
        Label statsLabel = new Label("Stats: ");
        Label abilitiesLabel = new Label("Abilities: ");

        //TODO: packs all the labels into one object to update them later
        PanelComponents comps = new PanelComponents(nameLabel, typeLabel, specializationLabel, statsLabel, abilitiesLabel);
        panel.setUserData(comps);

        panel.getChildren().addAll(iv, nameLabel, typeLabel, specializationLabel, statsLabel, abilitiesLabel);
        return panel;
    }

    private void updatePanel(VBox panel, Unit unit)
    {
        if (unit == null) return;
        PanelComponents comps = (PanelComponents) panel.getUserData();

        //TODO: fills in all the label text with info from the unit
        comps.nameLabel.setText("Name: " + unit.getUnitName());
        comps.typeLabel.setText("Type: " + unit.getUnitType());
        comps.specializationLabel.setText("Specialization: " + unit.getSpecialization());
        comps.statsLabel.setText("Price: " + unit.getPrice() +
                " | Armor: " + unit.getArmor() +
                " | Health: " + unit.getHealth());
        comps.abilitiesLabel.setText("Abilities: " + unit.getAbilities());
    }

    //TODO: stores all the labels for one side so they're easy to update
    private static class PanelComponents
    {
        Label nameLabel;
        Label typeLabel;
        Label specializationLabel;
        Label statsLabel;
        Label abilitiesLabel;

        PanelComponents(Label nameLabel, Label typeLabel, Label specializationLabel, Label statsLabel, Label abilitiesLabel)
        {
            this.nameLabel = nameLabel;
            this.typeLabel = typeLabel;
            this.specializationLabel = specializationLabel;
            this.statsLabel = statsLabel;
            this.abilitiesLabel = abilitiesLabel;
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
