package com.lss.sorm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

/**
 * Created by shuangshuangl on 2018/8/20.
 */
public class TopologyMain {
    public static void main(String[] args) throws Exception {
        TopologyBuilder builder =  new TopologyBuilder();
        builder.setSpout("name", new WordReader(), 5);
        builder.setBolt("exclaim", new WordCounter(), 5).shuffleGrouping("name");

        Config conf = new Config();
        conf.setDebug(false);
        conf.put(Config.TOPOLOGY_DEBUG, false);

        if (args != null && args.length > 0) {
            conf.setNumWorkers(10);
            StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
        } else {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("test", conf, builder.createTopology());
            Utils.sleep(10000);
            cluster.killTopology("test");
            cluster.shutdown();
        }
    }

}
