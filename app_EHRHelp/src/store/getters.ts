/**
 * 获取代码表对象
 * 
 * @param state 
 */
export const getCodeList = (state: any) => (srfkey: string) => {
    return state.codelists.find((_codelist: any) => Object.is(_codelist.srfkey, srfkey));
}

/**
 * 获取代码表
 * 
 * @param state 
 */
export const getCodeListItems = (state: any) => (srfkey: string) => {
    let items: any[] = [];
    const codelist = state.codelists.find((_codelist: any) => Object.is(_codelist.srfkey, srfkey));
    if (!codelist) {
        console.log(`----${srfkey}----代码表不存在`);
    } else {
        items = [...codelist.items];
    }
    return items;
}

/**
 * 获取本地应用数据
 * 
 * @param state 
 */
export const getLocalData = (state: any) => () => {
    return state.localdata;
}

/**
 * 获取应用数据
 * 
 * @param state 
 */
export const getAppData = (state: any) => () => {
    return state.appdata;
}

/**
 * 获取导航标签页面
 * 
 * @param state 
 */
export const getPage = (state: any) => (arg: any) => {
    let page: any = null;
    if (isNaN(arg)) {
        const index = state.pageTagList.findIndex((page: any) => Object.is(page.fullPath, arg));
        if (index >= 0) {
            page = state.pageTagList[index];
        }
    } else {
        page = state.pageTagList[arg];
    }
    return page;
}

/**
 * 获取 z-index 
 * 
 * @param state 
 */
export const getZIndex = (state: any) => () => {
    return state.zIndex;
}

/**
 * 获取视图split
 * 
 * @param state 
 */
export const getViewSplit = (state: any) => (viewUID: string) => {
  return state.viewSplit[viewUID];
}