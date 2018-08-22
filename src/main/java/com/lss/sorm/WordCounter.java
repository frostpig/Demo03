package com.lss.sorm;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuangshuangl on 2018/8/20.
 */
public class WordCounter implements IRichBolt {
    OutputCollector m_collector;
    public Map<String, Integer> NameCountMap = new HashMap<String, Integer>();

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        m_collector = collector;
    }

    public void execute(Tuple input) {
        // 第一步，统计计算
        Integer value = 0;
        if (NameCountMap.containsKey(input.getString(0))) {
            value = NameCountMap.get(input.getString(0));
        }
        NameCountMap.put(input.getString(0), ++value);

        // 第二步，输出
        System.out.println(input.getString(0) + "!!!");
        System.out.println(value);

        m_collector.ack(input);
    }

    @Override
    public void cleanup() {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("name"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
