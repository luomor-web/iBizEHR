<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORRedirectViewBase from './ormorgsectorredirect-view-base.vue';


/**
 * 部门管理数据重定向视图
 *
 * @export
 * @class ORMORGSECTORRedirectView
 * @extends {ORMORGSECTORRedirectViewBase}
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
export default class ORMORGSECTORRedirectView extends ORMORGSECTORRedirectViewBase { }
</script>