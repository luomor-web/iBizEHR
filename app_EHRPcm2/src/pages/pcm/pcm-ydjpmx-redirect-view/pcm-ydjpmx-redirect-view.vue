<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxRedirectViewBase from './pcm-ydjpmx-redirect-view-base.vue';


/**
 * 异动解聘明细数据重定向视图
 *
 * @export
 * @class PcmYdjpmxRedirectView
 * @extends {PcmYdjpmxRedirectViewBase}
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
export default class PcmYdjpmxRedirectView extends PcmYdjpmxRedirectViewBase { }
</script>