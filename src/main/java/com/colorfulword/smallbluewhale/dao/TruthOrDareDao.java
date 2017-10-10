package com.colorfulword.smallbluewhale.dao;

import com.colorfulword.smallbluewhale.domain.TruthOrDare;

import java.util.List;

/**
 * Created by jone.sun on 2017/8/8.
 */
public interface TruthOrDareDao {
    List<TruthOrDare> list();

    int insert(TruthOrDare truthOrDare);

    int delete(Integer truthOrDareId);
}
