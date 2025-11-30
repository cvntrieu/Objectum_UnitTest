package lma.objectum.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lma.objectum.Database.DatabaseConnection;
import lma.objectum.Utils.StageUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lma.objectum.Models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class AddBooksControllerTest extends ApplicationTest { // Kiem thu javafx app nen phai extend ApplicationTest

    // AddBook nam trong Controller nen buoc phai goi controller
    // Phai tao object vi cac phuong thuc trong addBookController la non-staic
    // (non-static cannot be referenced in static-method)
    private AddBooksController controller;

    @BeforeEach
    void setUp() { // set du lieu truoc moi test
        controller = new AddBooksController();

        controller.setTitleTextField(new TextField());
        controller.setIsbnTextField(new TextField());
        controller.setIsbn13TextField(new TextField());
        controller.setAuthorTextField(new TextField());
        controller.setPublicationYearTextField(new TextField());
        controller.setPublisherTextField(new TextField());
        controller.setQuantityTextField(new TextField());
        controller.setRatingTextField(new TextField());
        controller.setImageTextField(new TextField());
        controller.setAddBookMessageLabel(new Label());

        controller.titleTextField.setText("Book1");
        controller.isbnTextField.setText("123");
        controller.isbn13TextField.setText("1234567890123");
        controller.authorTextField.setText("Person1");
        controller.publicationYearTextField.setText("2010");
        controller.publisherTextField.setText("Publisher1");
        controller.quantityTextField.setText("1");
        controller.ratingTextField.setText("2.5");
        controller.imageTextField.setText("http://image");
    }

    // Kiem thu bien manh: min-, min, min+, normal, max-, max, max+
    @Test
    void test1() { // gia tri ko hop le cua quantity => pass khi trung voi code line 119 cua addbookController: quantity dc reset ve 0
        controller.quantityTextField.setText("-1");
        controller.addButtonOnAction(); // addButtonOnAction la phuong thuc can chay de kiem thu
        assertEquals(0, controller.quantity);
    }

    @Test
    void test2() { // gia tri bien
        controller.quantityTextField.setText("0");
        controller.addButtonOnAction();
        assertEquals(0, controller.quantity);
    }

    @Test
    void test3() {
        controller.quantityTextField.setText("1");
        controller.addButtonOnAction();
        assertEquals(1, controller.quantity);
    }

    @Test
    void test4() {
        controller.ratingTextField.setText("-1");
        controller.addButtonOnAction();
        assertEquals(0, controller.rating);
    }

    @Test
    void test5() {
        controller.ratingTextField.setText("6");
        controller.addButtonOnAction();
        assertEquals(0, controller.rating);
    }

    @Test
    void test6() {
        controller.ratingTextField.setText("0");
        controller.addButtonOnAction();
        assertEquals(0, controller.rating);
    }

    @Test
    void test7() {
        controller.ratingTextField.setText("5");
        controller.addButtonOnAction();
        assertEquals(5, controller.rating);
    }

    @Test
    void test8() {
        controller.ratingTextField.setText("0.1");
        controller.addButtonOnAction();
        assertEquals(0.1, controller.rating);
    }

    @Test
    void test9() {
        controller.ratingTextField.setText("4.9");
        controller.addButtonOnAction();
        assertEquals(4.9, controller.rating);
    }

    @Test
    void test10() {
        controller.ratingTextField.setText("2.5");
        controller.addButtonOnAction();
        assertEquals(2.5, controller.rating);
    }
}