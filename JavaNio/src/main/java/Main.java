



import java.io.*;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {
try {
//
//
//    FileChannel binChannel = bineFile.getChannel();
//    ByteBuffer buffer = ByteBuffer.allocate(100);
//    byte[] outputByte = "Hello Word".getBytes();
//    buffer.put(outputByte);
//    long int11Pos = outputByte.length;
//
//    buffer.putInt(245);
//    long int2Pos = int11Pos + Integer.BYTES;
//    buffer.putInt(-300);
//    byte[] outputByte2 = "Nice to meet you".getBytes();
//    buffer.put(outputByte2);
//    buffer.putInt(1000);
//    buffer.flip();
//    binChannel.write(buffer);

    RandomAccessFile ra = new RandomAccessFile("data.txt", "rwd");
    InputStream is = new FileInputStream(new File("data.txt"));


    FileChannel channel = ra.getChannel();
    RandomAccessFile copyTo = new RandomAccessFile("Copied.txt", "rw");
    FileChannel copyChannel = copyTo.getChannel();
    long byteSize = copyChannel.transferFrom(channel, 0, channel.size());
//
//    ByteBuffer b = ByteBuffer.allocate(Integer.BYTES);
//    channel.position(int2Pos);
//    channel.read(b);
//    b.flip();
//    System.out.println(b.getInt());
    //
//    ByteBuffer readBuffer = ByteBuffer.allocate(100);
//    channel.read(readBuffer);
//    readBuffer.flip();
//    byte[] inputStream = new byte[outputByte.length];
//    readBuffer.get(inputStream);
//
//    System.out.println("InputSteam = " + new String(inputStream));
//    System.out.println(readBuffer.getInt());
//    System.out.println(readBuffer.getInt());

//    InputStream is = new FileInputStream(new File("Data.dat"));
//    BufferedReader d = new BufferedReader(new InputStreamReader(is));
//   String line;
//    while((line = d.readLine())!=null){
//        System.out.println(line);
//    }
}
catch (IOException e){
    e.printStackTrace();
}
    }
}
