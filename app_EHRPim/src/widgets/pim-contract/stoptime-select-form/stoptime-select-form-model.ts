/**
 * StoptimeSelect 部件模型
 *
 * @export
 * @class StoptimeSelectModel
 */
export default class StoptimeSelectModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof StoptimeSelectModel
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
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'htbh',
        prop: 'htbh',
        dataType: 'TEXT',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'contracttype',
        prop: 'contracttype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'htzt',
        prop: 'htzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'htsyts',
        prop: 'htsyts',
        dataType: 'INT',
      },
      {
        name: 'htsyts_color',
        prop: 'htsyts_color',
        dataType: 'INT',
      },
      {
        name: 'pimcontractid',
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'pimcontract',
        prop: 'pimcontractid',
        dataType: 'FONTKEY',
      },
    ]
  }

}