package jp.ac.it_college.std.s14006.pdp;

import jp.ac.it_college.std.nakasone.lib.exam.Communicator;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by kabotya on 15/06/28.
 */

public class Main {

    public static void main(String[] args) {

        Communicator comm = new Communicator((msg) -> {
            System.out.print(msg);
        });
        comm.start();

        try {

            System.out.println("名前を入力");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            comm.send(name + "が入室しました");

            while (true) {
                Scanner scan = new Scanner(System.in);
                String smsg = scan.nextLine();

                if (smsg.equals("exit")) {
                    comm.send(name + "が退出しました");
                    comm.finish();
                    break;
                } else {
                    comm.send(name + ":" + smsg);
                }

            }

        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}