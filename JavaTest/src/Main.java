

//import java.nio.channels.Channel;


import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    private static RandomAccessFile ra;

    public static void main(String args[]) throws IOException {
        String sample = " session = jsch.getSession(\"centralmichigan\", \"signalvine.moveitcloud.com\", 22);";

        RandomAccessFile rnd = new RandomAccessFile("sample.dat", "rwd");
        rnd.writeInt(100);
        int indexSize= 100*3*Integer.BYTES;
        System.out.println(rnd.getFilePointer());
        int locs = (int)(indexSize + rnd.getFilePointer() + Integer.BYTES);

        rnd.writeInt(locs);
        System.out.println(rnd.getFilePointer());
        rnd.seek(locs);
        rnd.writeUTF(sample);
        System.out.println(rnd.getFilePointer());
        rnd.writeInt(300);
        System.out.println(rnd.getFilePointer());
        rnd.writeInt(400);
        System.out.println(rnd.getFilePointer());

        long pointer = rnd.getFilePointer();
        ra = new RandomAccessFile("sample.dat", "rwd");
        long loc = ra.readInt();
        long loc2 = ra.readInt();
        String name = ra.readUTF();
        long loc3 = ra.readInt();
        System.out.println("Reading file pointer: " + ra.getFilePointer());
            rnd.seek(rnd.getFilePointer());
            System.out.println(loc);
        System.out.println(loc2);
        System.out.println(name);
        System.out.println(loc3);
        ra.seek(locs);
        System.out.println(ra.getFilePointer());
        System.out.println("--------------");
        ra = new RandomAccessFile("locations_rand.dat", "rwd");
        ra.seek(8715);
        System.out.println(ra.readInt());
/*
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession("centralmichigan", "signalvine.moveitcloud.com", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("2p_bWzAG");
            session.connect();

            Channel channel = session.openChannel ("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get("/Home/Central Michigan University/Import/CMU_To_SignalVine_NSS_OptOut.csv", "C:/Users/khan2r/Documents/localfile.csv");
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }*/
    }
   }


