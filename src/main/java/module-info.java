open module javafx.sample.assignment {
    requires transitive javafx.fxml;
    requires transitive javafx.web;
    requires transitive javafx.swing;
    //if any unrelated error occurred, first invalidate(file)then rebuild(tools)
}