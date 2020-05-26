<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMQYGLRedirectViewBase from './ormqyglredirect-view-base.vue';


/**
 * 区域管理数据重定向视图
 *
 * @export
 * @class ORMQYGLRedirectView
 * @extends {ORMQYGLRedirectViewBase}
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
export default class ORMQYGLRedirectView extends ORMQYGLRedirectViewBase { }
</script>