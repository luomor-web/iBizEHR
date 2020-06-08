<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMKQDZRedirectViewBase from './ormbmkqdzredirect-view-base.vue';


/**
 * 部门地址维护数据重定向视图
 *
 * @export
 * @class ORMBMKQDZRedirectView
 * @extends {ORMBMKQDZRedirectViewBase}
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
export default class ORMBMKQDZRedirectView extends ORMBMKQDZRedirectViewBase { }
</script>