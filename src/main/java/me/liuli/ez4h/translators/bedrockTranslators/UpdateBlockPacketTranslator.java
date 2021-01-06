package me.liuli.ez4h.translators.bedrockTranslators;

import com.github.steveice10.mc.protocol.data.game.entity.metadata.Position;
import com.github.steveice10.mc.protocol.data.game.world.block.BlockChangeRecord;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.nukkitx.math.vector.Vector3i;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateBlockPacket;
import me.liuli.ez4h.bedrock.Client;
import me.liuli.ez4h.translators.BedrockTranslator;
import me.liuli.ez4h.translators.converters.BlockConverter;

public class UpdateBlockPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        UpdateBlockPacket packet=(UpdateBlockPacket)inPacket;
        Vector3i pos=packet.getBlockPosition();
        String name= BlockConverter.getBedrockNameByRuntime(packet.getRuntimeId());
        client.sendPacket(new ServerBlockChangePacket(new BlockChangeRecord(new Position(pos.getX(), pos.getY(), pos.getZ()), BlockConverter.getBlockByName(name))));
    }
}
