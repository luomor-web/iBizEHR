/**
 * 提交统一资源数据
 * 
 * @param param0 
 * @param data 
 */
export const commitAuthData = ({ commit, state }: { commit: any, state: any }, { unires,appmenu,enablepermissionvalid }: { unires: Array<any>, appmenu: Array<any>, enablepermissionvalid: boolean }) => {
    if(unires && unires.length > 0){
        commit('setResourceData', unires);
    }
    if(appmenu && appmenu.length >0){
        commit('setMenuData', appmenu);
    }
    if(enablepermissionvalid){
        commit('setEnablePermissionValid', enablepermissionvalid);
    }
}