<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParTzggRedirectViewBase from './par-tzgg-redirect-view-base.vue';


/**
 * 通知公告数据重定向视图
 *
 * @export
 * @class ParTzggRedirectView
 * @extends {ParTzggRedirectViewBase}
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
export default class ParTzggRedirectView extends ParTzggRedirectViewBase { }
</script>