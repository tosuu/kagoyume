package kagoyume;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * /
     * 
    /* 検索キーワードが空でなければ、以下の処理を実行する
    * connectApiで検索キーワードと一致するjsonを取得
    * getPartOfJsonで取得したjsonから商品名、価格、写真、コードを取り出してsdbにセットし、ArrayListで返す
    * その後、search.jspに画面遷移する*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // セッションのインスタンスを生成
        HttpSession session = request.getSession();
        Api api = new Api();
        SearchDataBeans sdb = new SearchDataBeans();
        try{
            if (!request.getParameter("name").equals("")) {
                String name = request.getParameter("name");
                sdb.setName(name);
                session.setAttribute("sdb", sdb);
                System.out.println("Session updated!!");
                
                ArrayList<SearchDataBeans> itemData = api.getResult(name);
                session.setAttribute("itemData", itemData);
                
                // 直リンク防止用のパラメータ
                session.setAttribute("ac", (int) (Math.random() * 1000));
                out.print("検索語句" + name + "を取得できました。searchに遷移します");
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "検索語句が未入力です");
                request.getRequestDispatcher("/top.jsp").forward(request, response);
            }
        }catch(NullPointerException e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
