import com.jcraft.jsch.*;

public class SFTPSend {

    String Method, RemoteSource, RemoteDestination, Username, Pass, Host;

    public SFTPSend()
    {
        this.Method = "";
        this.RemoteSource = "";
        this.RemoteDestination = "";
        this.Username = "";
        this.Pass = "";
        this.Host = "";
    }

    public void execute( String Method, String RemoteSource, String RemoteDestination, String Username, String Pass, String Host)
    {
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(Username, Host, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(Pass);
            session.connect();



            Channel channel = session.openChannel ("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            System.out.println(Method.toLowerCase());
            if (Method ==  "Send"){
            sftpChannel.put(RemoteSource, RemoteDestination);
           // System.out.println("Successfully Sent");
            } else if(Method.toLowerCase() ==  "Get"){
                sftpChannel.get(RemoteSource, RemoteDestination);
            }
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
}
