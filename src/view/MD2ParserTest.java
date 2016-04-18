package view;

import md2parsertest.MD2Obj;

/**
 *
 * @author leonardo
 */
public class MD2ParserTest {

    public static void main(String[] args) throws Exception {
        MD2Obj poss = new MD2Obj("/res/poss_body.md2", 1);
        System.out.println(poss.getHeader());
    }
    
}
