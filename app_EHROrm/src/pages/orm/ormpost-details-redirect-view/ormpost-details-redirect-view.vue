<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostDetailsRedirectViewBase from './ormpost-details-redirect-view-base.vue';


/**
 * 岗位明细数据重定向视图
 *
 * @export
 * @class ORMPostDetailsRedirectView
 * @extends {ORMPostDetailsRedirectViewBase}
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
export default class ORMPostDetailsRedirectView extends ORMPostDetailsRedirectViewBase { }
</script>