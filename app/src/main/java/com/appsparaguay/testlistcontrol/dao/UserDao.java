package com.appsparaguay.testlistcontrol.dao;

import com.appsparaguay.testlistcontrol.model.User;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrador on 9/7/2015.
 */
public class UserDao {
    public static ArrayList<User> lista;

    static {
        lista = new ArrayList<>();
        lista.add(new User("If debugging is the process of removing software bugs, then programming must be the process of putting them in.", "Edsger Dijkstra"));
        lista.add(new User("Measuring programming progress by lines of code is like measuring aircraft building progress by weight.", "Bill Gates"));
        lista.add(new User("Nine people can’t make a baby in a month.", "Fred Brooks"));
        lista.add(new User("Any fool can write code that a computer can understand. Good programmers write code that humans can understand.", "Martin Fowler"));
        lista.add(new User("Programming is like sex. One mistake and you have to support it for the rest of your life.", "Michael Sinz"));
        lista.add(new User("When debugging, novices insert corrective code; experts remove defective code.", "Richard Pattis"));
        lista.add(new User("Most good programmers do programming not because they expect to get paid or get adulation by the public, but because it is fun to program.", "Linus Torvalds"));
        lista.add(new User("One of my most productive days was throwing away 1000 lines of code.", "Ken Thompson"));
    }

    private static User user;

    public static User getRandomQuote() {
        final Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        User user = lista.get(rand.nextInt(lista.size()));
        return user;
    }

    public static int getTotal() {
        return lista.size();
    }
}
