/**
 * 数据保存后处理逻辑
 * 
 * @param param0 
 * @param data 
 */
export const datasaved = ({ commit, state }: { commit: any, state: any }, data: any) => {
    const createdviews: any[] = state.createdviews;

    // 唯一标识获取临时数据参数
    const { viewtag: secondtag } = data;
    const createdview: any = createdviews.find((item: any) => Object.is(item.secondtag, secondtag));
    if (!createdview) {
        return;
    }

    // 视图发布唯一标识
    const { viewtag: _viewtag } = createdview;
    createdviews.forEach((item: any) => {
        // 当前视图不参与刷新处理
        if (Object.is(item.secondtag, secondtag)) {
            return;
        }
        const {
            refviews: _refviews,
            secondtag: _secondtag,
        }: {
            refviews: string[],
            _refviews: string[],
            secondtag: string,
            _secondtag: string,
        } = item;
        _refviews.some((viewid: string) => {
            if (Object.is(viewid, _viewtag)) {
                // 被引用视图刷新
                commit('refreshViewData', { viewtag: _secondtag });
                return true;
            }
            return false;
        });
    });
}