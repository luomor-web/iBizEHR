/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
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
        prop: 'orgid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'orgname',
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
        name: 'orgname',
        prop: 'orgname',
        dataType: 'TEXT',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'shortname',
        prop: 'shortname',
        dataType: 'TEXT',
      },
      {
        name: 'porgid',
        prop: 'porgid',
        dataType: 'PICKUP',
      },
      {
        name: 'porgname',
        prop: 'porgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'px',
        prop: 'px',
        dataType: 'INT',
      },
      {
        name: 'zzlx',
        prop: 'zzlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gsss',
        prop: 'gsss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'btqy',
        prop: 'btqy',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ssou',
        prop: 'ssou',
        dataType: 'TEXT',
      },
      {
        name: 'zzcjsj',
        prop: 'zzcjsj',
        dataType: 'DATE',
      },
      {
        name: 'legalentity',
        prop: 'legalentity',
        dataType: 'SSCODELIST',
      },
      {
        name: 'startstopsign',
        prop: 'startstopsign',
        dataType: 'SSCODELIST',
      },
      {
        name: 'correspondingorg',
        prop: 'correspondingorg',
        dataType: 'TEXT',
      },
      {
        name: 'xn',
        prop: 'xn',
        dataType: 'YESNO',
      },
      {
        name: 'levelcode',
        prop: 'levelcode',
        dataType: 'TEXT',
      },
      {
        name: 'erporgid',
        prop: 'erporgid',
        dataType: 'TEXT',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'GUID',
      },
      {
        name: 'ormorg',
        prop: 'orgid',
        dataType: 'FONTKEY',
      },
    ]
  }

}