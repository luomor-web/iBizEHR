/**
 * 判断指定统一资源是否存在
 * 
 * @param state 
 */
export const getResourceData = (state: any) => (resourcetag: string) => {
    let itemIndex: any = state.resourceData.findIndex((obj: any, objIndex: any, objs: any) => {
        return Object.is(obj.unirescode, resourcetag);
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