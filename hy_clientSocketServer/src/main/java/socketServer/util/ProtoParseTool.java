package socketServer.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.moxi.proBuf.ProEvent;
import com.moxi.proBuf.ProEventOrBuilder;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 20:04
 */

public class ProtoParseTool {
    public void parse(){

    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        ProEvent event= ProEvent.newBuilder()
                .setEventType("test").build();
        byte[] arrs=event.toByteArray();
        ProEvent ete=ProEvent.parseFrom(arrs);
        System.out.println(ete);
    }
}
