<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPATENTRedirectViewBase from './pimpatentredirect-view-base.vue';


/**
 * 专利信息数据重定向视图
 *
 * @export
 * @class PIMPATENTRedirectView
 * @extends {PIMPATENTRedirectViewBase}
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
export default class PIMPATENTRedirectView extends PIMPATENTRedirectViewBase { }
</script>