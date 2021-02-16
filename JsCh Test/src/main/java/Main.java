public class Main {



    public static void main(String args[]){

        SFTPSend ssend = new SFTPSend();
        ssend.execute("Send", "//udrive/khan2r$/CMU_To_SignalVine_NSS_OptOut.csv", "/Home/Central Michigan University/Import/UAT/Test.csv", "centralmichigan", "2p_bWzAG", "signalvine.moveitcloud.com");
        /*Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession("centralmichigan", "signalvine.moveitcloud.com", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("2p_bWzAG");
            session.connect();

            Channel channel = session.openChannel ("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put("//udrive/khan2r$/CMU_To_SignalVine_NSS_OptOut.csv", "/Home/Central Michigan University/Import/UAT/Test.csv");
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }*/
    }

}
