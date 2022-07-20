package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

   public static String converterDateParaDataEHora(Date data) {
      SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      return formatador.format(data);

      // 12/11/2022 12:47:53hs

   }
}
/**
 * modo de converção de data e hora estatica
 * 
 */