package br.com.pearson.maillist.Memento;

import android.util.Log;

/**
 * Created by pearson on 22/09/16.
 */
public class Originator {
    private String state;

    public void set(String state) {
        Log.i("Originator","Setting state to "+state);
        this.state = state;
    }

    public Memento saveToMemento() {
        Log.i("Originator","Saving to Memento.");
        return new Memento(state);
    }
    public String restoreFromMemento(Memento m) {
        Log.i("Originator","State after restoring from Memento: "+state);
        return m.getSavedState();
    }
}