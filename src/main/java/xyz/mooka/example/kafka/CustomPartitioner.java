package xyz.mooka.example.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CustomPartitioner implements Partitioner {
    private final static Logger logger = LoggerFactory.getLogger(CustomPartitioner.class);

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        if(keyBytes == null) throw new InvalidRecordException("Need Message key");
        if(key.toString().equals("pangyo")) return 0;

        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        int partition = Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
//        logger.info(numPartitions +"=>" +partition);
        return partition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
