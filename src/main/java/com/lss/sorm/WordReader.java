package com.lss.sorm;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Random;

/**
 * Created by shuangshuangl on 2018/8/20.
 */
public class WordReader implements IRichSpout {
    SpoutOutputCollector m_collector;

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        m_collector = collector;
    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    public void nextTuple() {
        final String[] names = new String[]{"nathan", "mike", "jackson", "golda", "bertels"};
        final Random rand = new Random();
        final String name = names[rand.nextInt(names.length)];

        Utils.sleep(10);
        m_collector.emit(new Values(name));
    }

    @Override
    public void ack(Object msgId) {

    }

    @Override
    public void fail(Object msgId) {

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("name"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
