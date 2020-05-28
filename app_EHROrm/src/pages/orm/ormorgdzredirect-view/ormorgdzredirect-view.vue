<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGDZRedirectViewBase from './ormorgdzredirect-view-base.vue';


/**
 * 组织地址维护数据重定向视图
 *
 * @export
 * @class ORMORGDZRedirectView
 * @extends {ORMORGDZRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMORGDZRedirectView extends ORMORGDZRedirectViewBase { }
</script>