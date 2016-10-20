package br.com.pearson.maillist.Memento;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by pearson on 22/09/16.
 */
public class Caretaker {
    Deque<Memento> stack = new ArrayDeque<Memento>();

    public void pushMemento(Memento m) {

        if (m.getSavedState().equals(" ")) {
            return;
        }

        if (stack.size() == 0) {
            stack.push(new Memento(""));
        }

        stack.push(m);
    }

    public Memento popMemento() {

        if (stack.size() > 0) {
            stack.pop();

            if (stack.size() > 1) {
                stack.pop();
            }
        }

        Log.d("Caretaker", stack.toString());

        return stack.getFirst();


    }
}
