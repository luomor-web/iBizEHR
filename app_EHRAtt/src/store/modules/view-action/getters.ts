/**
 * 获取应用视图数据
 * 
 * @param state 
 */
export const getAppView = (state: any) => (viewtag: string) => {
    const createdview = state.createdviews.find((appview: any) => Object.is(appview.secondtag, viewtag));
    if (!createdview) {
        console.log(`----视图 ${viewtag} 不存在-----`)
        return null;
    }
    return createdview;
}

/**
 * 获取视图数据变化状态
 * 
 * @param state 
 */
export const getViewDataChangeState = (state:any) => (viewtag: string) => {
    const createdview = state.createdviews.find((appview: any) => Object.is(appview.secondtag, viewtag));
    if (!createdview) {
        console.log(`----视图 ${viewtag} 不存在-----`)
        return false;
    }
    return createdview.viewdatachange;
}

/**
 * 获取视图是否需要刷新
 * 
 * @param state 
 */
export const getRefreshData = (state: any) => (viewtag: string) => {
    const createdview = state.createdviews.find((appview: any) => Object.is(appview.secondtag, viewtag));
    if (!createdview) {
        console.log(`----视图 ${viewtag} 不存在-----`)
        return null;
    }
    return createdview.refreshdata;
}