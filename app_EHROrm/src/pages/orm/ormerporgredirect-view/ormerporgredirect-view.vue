<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMERPORGRedirectViewBase from './ormerporgredirect-view-base.vue';


/**
 * ERP组织中间表数据重定向视图
 *
 * @export
 * @class ORMERPORGRedirectView
 * @extends {ORMERPORGRedirectViewBase}
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
export default class ORMERPORGRedirectView extends ORMERPORGRedirectViewBase { }
</script>