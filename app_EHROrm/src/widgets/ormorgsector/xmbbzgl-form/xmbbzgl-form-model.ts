/**
 * XMBBZGL 部件模型
 *
 * @export
 * @class XMBBZGLModel
 */
export default class XMBBZGLModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof XMBBZGLModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'shortname',
        prop: 'shortname',
        dataType: 'TEXT',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'ordervalue',
        prop: 'ordervalue',
        dataType: 'INT',
      },
      {
        name: 'belongregion',
        prop: 'belongregion',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qy',
        prop: 'qy',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xmblx',
        prop: 'xmblx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'prodepid',
        prop: 'prodepid',
        dataType: 'PICKUP',
      },
      {
        name: 'prodepname',
        prop: 'prodepname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormxmglname',
        prop: 'ormxmglname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xmbh',
        prop: 'xmbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'engineeringscale',
        prop: 'engineeringscale',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'gkjz',
        prop: 'gkjz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'belongou',
        prop: 'belongou',
        dataType: 'TEXT',
      },
      {
        name: 'startstopsign',
        prop: 'startstopsign',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'bmbzrs',
        prop: 'bmbzrs',
        dataType: 'INT',
      },
      {
        name: 'sjbzrs',
        prop: 'sjbzrs',
        dataType: 'TEXT',
      },
      {
        name: 'bmlx',
        prop: 'bmlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'validflag',
        prop: 'validflag',
        dataType: 'YESNO',
      },
      {
        name: 'xmbq',
        prop: 'xmbq',
        dataType: 'TEXT',
      },
      {
        name: 'title',
        prop: 'title',
        dataType: 'TEXT',
      },
      {
        name: 'referjoblevel',
        prop: 'referjoblevel',
        dataType: 'SSCODELIST',
      },
      {
        name: 'orgtype',
        prop: 'orgtype',
        dataType: 'TEXT',
      },
      {
        name: 'zwbzsl',
        prop: 'zwbzsl',
        dataType: 'TEXT',
      },
      {
        name: 'gwbzsl',
        prop: 'gwbzsl',
        dataType: 'TEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'ormxmglid',
        prop: 'ormxmglid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsector',
        prop: 'orgsectorid',
        dataType: 'FONTKEY',
      },
    ]
  }

}