<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMEDITIONRedirectViewBase from './ormeditionredirect-view-base.vue';


/**
 * 版本对照表数据重定向视图
 *
 * @export
 * @class ORMEDITIONRedirectView
 * @extends {ORMEDITIONRedirectViewBase}
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
export default class ORMEDITIONRedirectView extends ORMEDITIONRedirectViewBase { }
</script>