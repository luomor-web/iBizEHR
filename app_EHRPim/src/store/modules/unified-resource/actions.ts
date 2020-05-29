/**
 * 提交统一资源数据
 * 
 * @param param0 
 * @param data 
 */
export const commitResourceData = ({ commit, state }: { commit: any, state: any }, { unires, enablepermissionvalid }: { unires: Array<any>, enablepermissionvalid: boolean }) => {
    if(unires && unires.length > 0){
        commit('setResourceData', unires);
    }
    if(enablepermissionvalid){
        commit('setEnablePermissionValid', enablepermissionvalid);
    }
}