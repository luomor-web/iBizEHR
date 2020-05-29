<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMRelationRedirectViewBase from './ormrelation-redirect-view-base.vue';


/**
 * 组织管理关系表数据重定向视图
 *
 * @export
 * @class ORMRelationRedirectView
 * @extends {ORMRelationRedirectViewBase}
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
export default class ORMRelationRedirectView extends ORMRelationRedirectViewBase { }
</script>