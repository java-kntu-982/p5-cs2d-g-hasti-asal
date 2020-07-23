open module javafx.sample.assignment {
    requires transitive javafx.fxml;
    requires transitive javafx.web;
    requires transitive javafx.swing;
    requires javafx.media;
    //if any unrelated error occurred, first invalidate(file)then rebuild(tools)
}