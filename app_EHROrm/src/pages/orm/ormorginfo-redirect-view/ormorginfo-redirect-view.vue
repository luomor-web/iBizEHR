<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGInfoRedirectViewBase from './ormorginfo-redirect-view-base.vue';


/**
 * 组织信息数据重定向视图
 *
 * @export
 * @class ORMORGInfoRedirectView
 * @extends {ORMORGInfoRedirectViewBase}
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
export default class ORMORGInfoRedirectView extends ORMORGInfoRedirectViewBase { }
</script>