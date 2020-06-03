<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPERRedirectViewBase from './pimpaperredirect-view-base.vue';


/**
 * 论文信息数据重定向视图
 *
 * @export
 * @class PIMPAPERRedirectView
 * @extends {PIMPAPERRedirectViewBase}
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
export default class PIMPAPERRedirectView extends PIMPAPERRedirectViewBase { }
</script>