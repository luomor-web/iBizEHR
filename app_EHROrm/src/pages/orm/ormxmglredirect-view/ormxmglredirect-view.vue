<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMGLRedirectViewBase from './ormxmglredirect-view-base.vue';


/**
 * 项目管理数据重定向视图
 *
 * @export
 * @class ORMXMGLRedirectView
 * @extends {ORMXMGLRedirectViewBase}
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
export default class ORMXMGLRedirectView extends ORMXMGLRedirectViewBase { }
</script>