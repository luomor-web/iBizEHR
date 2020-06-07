/**
 * 判断指定统一资源是否存在
 * 
 * @param state 
 */
export const getResourceData = (state: any) => (resourcetag: string) => {
    let itemIndex: any = state.resourceData.findIndex((unirescode: any, objIndex: any, objs: any) => {
        return Object.is(unirescode, resourcetag);
    })
    return itemIndex === -1 ? false : true;
}

/**
 * 判断指定菜单权限是否存在
 * 
 * @param state 
 */
export const getMenuData = (state: any) => (menutag: string) => {
    let itemIndex: any = state.menuData.findIndex((menucode: any, objIndex: any, objs: any) => {
        return Object.is(menucode, menutag);
    })
    return itemIndex === -1 ? false : true;
}

/**
 * 获取是否开启权限认证
 * 
 * @param state 
 */
export const getEnablePermissionValid = (state: any) => {
    return state.enablePermissionValid;
}

/**
 * 判断指定菜单是否显示
 * 
 * @param state 
 */
export const getAuthMenu = (state: any) => (menu:any) =>{
    // 存在权限
    let resourceIndex: any;
    let menuIndex:any;
    if(state.enablePermissionValid){
        resourceIndex= state.resourceData.findIndex((resourcetag: any, objIndex: any, objs: any) => {
            return Object.is(menu.resourcetag, resourcetag);
        })
    }
    menuIndex= state.menuData.findIndex((menutag: any, objIndex: any, objs: any) => {
        return Object.is(menu.authtag, menutag);
    })
    return (resourceIndex !== -1 || menuIndex !== -1)?true:false;
}