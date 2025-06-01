package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Author Nicholas Hilaire
 *
 * "Java: CSV File Easy Read/Write" https://stackoverflow.com/questions/14226830/java-csv-file-easy-read-write  
 * "How to Use BoxLayout" https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
 */

public class UnitCard extends VBox
{
    //TODO: image of the unit
    private ImageView unitImageView;

    //TODO: labels for unit info
    private Label unitNameLabel;
    private Label unitTypeLabel;
    private Label specializationLabel;
    private Label statsLabel;
    private Label abilitiesLabel;

    public UnitCard()
    {
        super(5); // spacing between each field

        //TODO: styling and padding
        setPadding(new Insets(10));
        setStyle("-fx-border-color: black; -fx-background-color: #f0f0f0;");

        //TODO: set up image view
        unitImageView = new ImageView();
        unitImageView.setId("unitImageView");
        unitImageView.setFitWidth(120);
        unitImageView.setFitHeight(80);
        unitImageView.setPreserveRatio(true);

        //TODO: set up labels
        unitNameLabel = new Label();
        unitNameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        unitTypeLabel = new Label();
        specializationLabel = new Label();
        statsLabel = new Label();
        abilitiesLabel = new Label();

        //TODO: add everything to the VBox
        getChildren().addAll(unitNameLabel, unitTypeLabel, specializationLabel, statsLabel, abilitiesLabel);
    }

    //TODO: display unit data in labels
    public void setUnit(Unit unit)
    {
        unitNameLabel.setText(unit.getUnitName());
        unitTypeLabel.setText("Type: " + unit.getUnitType());
        specializationLabel.setText("Spec: " + unit.getSpecialization());
        statsLabel.setText("Price: " + unit.getPrice() + " | Armor: " + unit.getArmor() + " | Health: " + unit.getHealth());
        abilitiesLabel.setText("Abilities: " + unit.getAbilities());
    }

    //TODO: update image shown on card
    public void setImage(Image image)
    {
        unitImageView.setImage(image);
    }
}
