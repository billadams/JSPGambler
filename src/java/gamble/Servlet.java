/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamble;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fssco
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String url = "";

        int bound = 13;
        Random rando = new Random();
        int numToShow = rando.nextInt(bound) + 1;
        
        if (action == null) {
            action = "nothing";
        }

        if (action.equals("nothing")) {
            url = "/index.jsp";

        } else if (action.equals("start")) {
            url = "/game.jsp";
            String name = request.getParameter("name");
            Double cash = Double.parseDouble(request.getParameter("money"));
            Player ourPlayer = new Player(name, cash);

            HttpSession session = request.getSession();
            session.setAttribute("player", ourPlayer);
            session.setAttribute("prevNumber", numToShow);
            request.setAttribute("numToShow", numToShow);

        } else if (action.equals("gamble")) {
            url = "/game.jsp";

//            String name = request.getParameter("name");
//            Double cash = Double.parseDouble(request.getParameter("money"));
//            Player ourPlayer = new Player(name, cash);
            HttpSession session = request.getSession();
            Player ourPlayer = (Player) session.getAttribute("player");

            if (ourPlayer == null) {
                url = "/index.jsp";
            } else {
                String choice = request.getParameter("choice");

//                int prevNumber = Integer.parseInt(request.getParameter("prevNumber"));
//                int prevNumber = (int) session.getAttribute("prevNumber");
                int prevNumber;
                Object prevNumberO = session.getAttribute("prevNumber");
                if (prevNumberO == null) {
                    prevNumber = 0;
                }
                else {
                    prevNumber = (int) prevNumberO;
                }

                request.setAttribute("prevNumber", numToShow);

                Boolean win = false;
                String message = "";
                int wager = 5;

                if (prevNumber > numToShow && choice.equals("low")) {
                    win = true;
                    message = "you win";
                    ourPlayer.setRoll(ourPlayer.getRoll() + wager);

                } else if (prevNumber < numToShow && choice.equals("high")) {
                    win = true;
                    message = "you win";
                    ourPlayer.setRoll(ourPlayer.getRoll() + wager);
                } else if (prevNumber == numToShow) {
                    message = "tie, you lose, hah hah";
                    ourPlayer.setRoll(ourPlayer.getRoll() - wager);
                } else {
                    message = "you lose, good day sir!";
                    ourPlayer.setRoll(ourPlayer.getRoll() - wager);
                }

//                request.setAttribute("player", ourPlayer);
                request.setAttribute("numToShow", numToShow);
                request.setAttribute("message", message);
                session.setAttribute("prevNumber", numToShow);
            }
        } else {
            url = "/index.jsp";
        }

        ServletContext sc = getServletContext();

        sc.getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
