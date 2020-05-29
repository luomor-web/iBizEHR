<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibRedirectViewBase from './ormpost-lib-redirect-view-base.vue';


/**
 * 岗位库数据重定向视图
 *
 * @export
 * @class ORMPostLibRedirectView
 * @extends {ORMPostLibRedirectViewBase}
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
export default class ORMPostLibRedirectView extends ORMPostLibRedirectViewBase { }
</script>