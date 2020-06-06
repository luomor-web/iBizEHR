/**
 * 设置统一资源数据
 * 
 * @param state 
 * @param resourceArray
 */
export const setResourceData = (state: any, resourceArray:Array<any>) => {
    if(resourceArray && resourceArray.length === 0){
        return;
    }
    state.resourceData = resourceArray;
}

/**
 * 设置菜单数据
 * 
 * @param state 
 * @param resourceArray
 */
export const setMenuData = (state: any, menuArray:Array<any>) => {
    if(menuArray && menuArray.length === 0){
        return;
    }
    state.menuData = menuArray;
}

/**
 * 设置是否开启权限认证
 * 
 * @param state 
 * @param resourceArray
 */
export const setEnablePermissionValid = (state: any, enablepermissionvalid:boolean) => {
    state.enablePermissionValid = enablepermissionvalid;
}
