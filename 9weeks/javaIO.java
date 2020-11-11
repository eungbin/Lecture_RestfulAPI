import java.io.*;

public class javaIO {
    public static void main(String[] args) {

    if (args.length != 2)
    {System.out.println("usage : >java javaIO <input-file name> <output-file name>");
	 System.exit(1);
    }

         String infilename= args[0];
         String outfilename= args[1];
         try {
            BufferedReader reader = new BufferedReader(new FileReader(infilename));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outfilename)));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            writer.println("���ο� XML���� ������ �����Ǿ����ϴ�.");

            reader.close();
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
