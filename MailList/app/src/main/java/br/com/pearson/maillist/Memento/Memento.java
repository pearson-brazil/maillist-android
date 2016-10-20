package br.com.pearson.maillist.Memento;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by pearson on 22/09/16.
 */
public class Memento {
    private String state;

    public Memento(String stateToSave) { state = stateToSave; }
    public String getSavedState() { return state; }

    @Override
    public String toString() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {

        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Memento m = (Memento) obj;
        if (m.state.equals(this.state)) {
            return true;
        }

        return false;
    }
}



