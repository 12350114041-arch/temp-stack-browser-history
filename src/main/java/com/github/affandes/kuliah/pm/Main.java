package com.github.affandes.kuliah.pm;

import java.util.Stack;

public class TextEditor {
    private String currentText = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void write(String text) {
        undoStack.push(currentText);
        currentText += text;
        redoStack.clear(); 
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-undo!");
        }
    }
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-redo!");
        }
    }
    public void show() {
        System.out.println("Isi Text Editor: " + currentText);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Hello");
        editor.show();

        editor.write(" World");
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.write("!");
        editor.show();

        editor.undo();
        editor.undo();
        editor.show();

        editor.redo();
        editor.show();
    }
}
