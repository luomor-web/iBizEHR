<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMFAMINFORedirectViewBase from './pimfaminforedirect-view-base.vue';


/**
 * 家庭情况数据重定向视图
 *
 * @export
 * @class PIMFAMINFORedirectView
 * @extends {PIMFAMINFORedirectViewBase}
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
export default class PIMFAMINFORedirectView extends PIMFAMINFORedirectViewBase { }
</script>